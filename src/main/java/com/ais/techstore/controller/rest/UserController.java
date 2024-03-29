package com.ais.techstore.controller.rest;

import com.ais.techstore.model.User;
import com.ais.techstore.service.UserService;
import com.ais.techstore.service.impl.UserDetailsImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(description = "Контроллер для управления пользователем")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Все пользователи", description = "Позволяет получить всех пользователей из базы данных")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Пользователь(id)", description = "Позволяет получить пользователя по 'id'")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByUsername/{name}")
    @Operation(summary = "Пользователь(name)", description = "Позволяет получить пользователя по имени")
    public ResponseEntity<User> getByUsername(@PathVariable String name) {
        try {
            return new ResponseEntity<>(userService.findUserByUsername(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByEmail/{email}")
    @Operation(summary = "Пользователь(email)", description = "Позволяет получить пользователя по по электронному адресу")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    @Operation(summary = "Добавление пользователя", description = "Позволяет добавить нового пользователя")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            userService.insert(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/2{id}")
    @Operation(summary = "Удаление пользователя", description = "Позволяет удалить пользователя")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    @Operation(summary = "Получения пользователя", description = "Позволяет получить пользователя")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            return new ResponseEntity<>(userService.findById(userDetails.getUserId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateUser")
    @Operation(summary = "Обновление пользователя", description = "Позволяет обновить пользователя")
    public ResponseEntity<?> editUserPage(@RequestBody User user) {
        try {
            userService.insert(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}