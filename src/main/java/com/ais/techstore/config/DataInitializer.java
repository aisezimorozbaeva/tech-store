package com.ais.techstore.config;

import com.ais.techstore.model.*;
import com.ais.techstore.service.CategoryService;
import com.ais.techstore.service.NewsService;
import com.ais.techstore.service.StockService;
import com.ais.techstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * класс первичного заполнения таблиц.
 * для первичного заполнения базы данных раскомментировать аннотацию
 * "@PostConstruct" и поменять значение  ключа "spring.jpa.hibernate.ddl-auto"
 * в файле "application.yml" с "update" на "create" или "create-drop".
 */
@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CategoryService categoryService;
    private final UserService userService;
    private final StockService stockService;
    private final NewsService newsService;

    /**
     * Основной метод для заполнения базы данных.
     * Вызов методов добавлять в этод метод.
     * Следить за последовательностью вызова.
     */
//    @PostConstruct
//    раскомментировать аннотацию при первом запуске проекта для создания таблиц БД, потом закомментировать
    public void initDataBaseFilling() {
        productsAndCategoriesInit();
        usersAndRolesInit();
        addStockInit();
        addNewsInit();
    }

    private void addNewsInit() {
        News news = new News();
        news.setName("AirPods Max");
        news.setNews("OUR NEW PRODUCTS FROM USA");
        LocalDate localTime =LocalDate.of(2022,11,10);
        news.setNewsTime(localTime);
        news.setNewsPrice(115000L);
        news.setNewsPicture("https://www.rollingstone.com/wp-content/uploads/2022/09/Apple-AirPods-Pro-2nd-gen-hero-220907.jpg");
        news.setNewsDetail("bluetooth headphones");
        newsService.save(news);


        News news1 = new News();
        news1.setName(" Smart Clock");
        news1.setNews("MOBILE TECHNOLOGIES (Apple)");
        LocalDate localTime1 =LocalDate.of(2022,10,27);
        news1.setNewsTime(localTime);
        news1.setNewsPrice(90000L);
        news1.setNewsPicture("https://avatars.mds.yandex.net/get-mpic/4372959/img_id4680417491209517689.jpeg/5");
        news1.setNewsDetail("6--128/256/512");
        newsService.save(news1);


    }

    private void productsAndCategoriesInit() {
        Product iPhone12 = new Product();
        iPhone12.setName("iPhone 14 Pro Max");
        iPhone12.setRating(3.7);
        iPhone12.setProductCount(15);
        iPhone12.setProductPrice(100182);
        iPhone12.setProductPicture("https://softech.kg/image/cache/63ccea961faf68e3d9e4b6f1e4d845c8.jpg");

        Description descriptionIPhone12 = new Description();
        descriptionIPhone12.setProductColor("Silver");
        descriptionIPhone12.setProductDimensions(160);
        descriptionIPhone12.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionIPhone12.setProductManufacturer("Assembled in China");
        descriptionIPhone12.setProductWeight(226);

        iPhone12.setDescription(descriptionIPhone12);

        Product dyson1 = new Product();
        dyson1.setName("СТАЙЛЕР DYSON AIRWRAP HS05 COMPLETE");
        dyson1.setRating(4.6);
        dyson1.setProductCount(30);
        dyson1.setProductPrice(45000);
        dyson1.setProductPicture("https://sotohit.ru/d/dyson_airwrap_complete_long_sinii_mednyi.png");

        Description descriptionDyson = new Description();
        descriptionDyson.setProductColor("Gold ");
        descriptionDyson.setProductDimensions(144);
        descriptionDyson.setProductGuarantee("Разработан для нескольких типов волос.\n");
        descriptionDyson.setProductManufacturer("Assembled in Turk");
        descriptionDyson.setProductWeight(245);

        dyson1.setDescription(descriptionDyson);

        Product macBookProI9 = new Product();
        macBookProI9.setName("MacBook Pro i9 - 1 ТБ");
        macBookProI9.setRating(4.3);
        macBookProI9.setProductCount(25);
        macBookProI9.setProductPrice(241965);
        macBookProI9.setProductPicture("https://tpc.ucf.edu/wp-content/uploads/sites/5/2020/03/macbook-air-spacegray-gallery2-20220606.png");

        Description descriptionMacBookProI9 = new Description();
        descriptionMacBookProI9.setProductColor("Space Gray");
        descriptionMacBookProI9.setProductDimensions(35);
        descriptionMacBookProI9.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionMacBookProI9.setProductManufacturer("Assembled in China");
        descriptionMacBookProI9.setProductWeight(2);

        macBookProI9.setDescription(descriptionMacBookProI9);

        Product refrigerator = new Product();
        refrigerator.setName("Холодильник Indesi t DS 316 W");
        refrigerator.setRating(3.5);
        refrigerator.setProductCount(12);
        refrigerator.setProductPrice(21290);
        refrigerator.setProductPicture("https://asiaexpress.kg/uploads/media/product_photo/0001/04/dbf456aa9100ba1fbccdf7fc19b47a9bd11d9ad1.jpeg");
        Description descriptionRefrigerator = new Description();
        descriptionRefrigerator.setProductColor("White");
        descriptionRefrigerator.setProductDimensions(167);
        descriptionRefrigerator.setProductGuarantee("3 years official warranty");
        descriptionRefrigerator.setProductManufacturer("Whirlpool Corporation");
        descriptionRefrigerator.setProductWeight(58);

        refrigerator.setDescription(descriptionRefrigerator);

        Product washingMachineLG = new Product();
        washingMachineLG.setName("Стиральная машина LG");
        washingMachineLG.setRating(3.9);
        washingMachineLG.setProductCount(14);
        washingMachineLG.setProductPrice(29000);
        washingMachineLG.setProductPicture("https://object.pscloud.io/cms/cms/Photo/img_0_8_629_0.png");

        Description washingMachineLGDescription = new Description();
        washingMachineLGDescription.setProductColor("тёмно-серый");
        washingMachineLGDescription.setProductDimensions(40);
        washingMachineLGDescription.setProductGuarantee("Гарантия: 3 года");
        washingMachineLGDescription.setProductManufacturer("Страна Россия");
        washingMachineLGDescription.setProductWeight(74);

        washingMachineLG.setDescription(washingMachineLGDescription);

        Product tv = new Product();
        tv.setName("LED ТЕЛЕВИЗОР BBK 32 LEX-7289");
        tv.setRating(3.1);
        tv.setProductCount(8);
        tv.setProductPrice(15000);
        tv.setProductPicture("https://m.media-amazon.com/images/I/71d5fMDvq9L._SL1500_.jpg");

        Description tvDescription = new Description();
        tvDescription.setProductColor("серый");
        tvDescription.setProductDimensions(64);
        tvDescription.setProductGuarantee("Гарантия: 1 год");
        tvDescription.setProductManufacturer("Страна Казакстан");
        tvDescription.setProductWeight(12);

        tv.setDescription(tvDescription);

        Product smartWatch = new Product();
        smartWatch.setName("Smart Watch");
        smartWatch.setRating(4.2);
        smartWatch.setProductCount(10);
        smartWatch.setProductPrice(10012);
        smartWatch.setProductPicture("https://cdn.shopify.com/s/files/1/0997/6284/files/nav-noise-colorfit-loop-smartwatch.png?v=18114716816441478335");

        Description descriptionsmCl = new Description();
        descriptionsmCl.setProductColor("Silver");
        descriptionsmCl.setProductDimensions(160);
        descriptionsmCl.setProductGuarantee("Apple One (1) Year Limited Warranty for Apple\n" +
                "-branded Products Only");
        descriptionsmCl.setProductManufacturer("Assembled in China");
        descriptionsmCl.setProductWeight(226);

        smartWatch.setDescription(descriptionsmCl);

        List<Product> productListTechnology = new ArrayList<>();
        productListTechnology.add(iPhone12);
        productListTechnology.add(dyson1);
        productListTechnology.add(macBookProI9);
        productListTechnology.add(smartWatch);

        Category categoryTechnology = new Category();
        categoryTechnology.setName("Technologies");
        categoryTechnology.setProducts(productListTechnology);
        categoryService.save(categoryTechnology);

        List<Product> productListWashingMachine = new ArrayList<>();
        productListWashingMachine.add(washingMachineLG);

        Category categoryWashingMachine = new Category();
        categoryWashingMachine.setName("Washing Machines");
        categoryWashingMachine.setProducts(productListWashingMachine);
        categoryService.save(categoryWashingMachine);

        List<Product> productListRefrigerator = new ArrayList<>();
        productListRefrigerator.add(refrigerator);

        Category categoryRefrigerator = new Category();
        categoryRefrigerator.setName("Refrigerators");
        categoryRefrigerator.setProducts(productListRefrigerator);
        categoryService.save(categoryRefrigerator);

        List<Product> productListTV = new ArrayList<>();
        productListTV.add(tv);

        Category categoryTV = new Category();
        categoryTV.setName("TV");
        categoryTV.setProducts(productListTV);
        categoryService.save(categoryTV);
    }


    private void usersAndRolesInit() {
        User user = new User();
        user.setUsername("user");
        user.setLastName("userov");
        user.setEmail("user@gmail.com");
        user.setPassword("$2a$12$S.ynke5509M87TBlHaEEvu7JBVPFWr5QRhJU4qB1m6o3V/T6MpsfK");
        user.setGender("Male");
        user.setPhoneNumber("0708565656");
        user.setProfilePicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7-d5qr9WzS926jiHDPlYrCL01Eb0M8C8c4w&usqp=CAU");

        LocalDate birthDate = LocalDate.of(1989, 6, 1);
        user.setBirthDate(birthDate);

        LocalDate registerDate = LocalDate.now();
        user.setRegisterDate(registerDate);

        Role role = new Role();
        role.setName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);

        userService.save(user);


        User admin = new User();
        admin.setUsername("admin");
        admin.setLastName("adminov");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("$2a$12$r9EPRztWrm.y2wN59w4.NOuyAjE1iJdofCo0acWTFGvU6oDA7eESK");
        admin.setGender("Male");
        admin.setPhoneNumber("0705250086");
        admin.setProfilePicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7-d5qr9WzS926jiHDPlYrCL01Eb0M8C8c4w&usqp=CAU");

        LocalDate birthDateAdmin = LocalDate.of(1989, 6, 1);
        admin.setBirthDate(birthDateAdmin);

        LocalDate registerDateAdmin = LocalDate.now();
        admin.setRegisterDate(registerDateAdmin);


        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);

        admin.setRoles(roles);

        userService.save(admin);
    }
    private void addStockInit(){
        Stock stock1 = new Stock();
        stock1.setName("Mackbook pro 13 m1");
        stock1.setStock(20l);
        LocalDate localTime =LocalDate.of(2022,12,12);
        stock1.setStockTime(localTime);
        stock1.setStockPrice(115000l);
        stock1.setStockPicture("https://softech.kg/image/cache/cdcc7e62c117e5e900209ba89798c3a7.jpg");
        stockService.save(stock1);

        Stock stock3 = new Stock();
        stock3.setName("Xiaomi Mi NoteBook Pro X 15");
        stock3.setStock(15l);
        LocalDate localTime3 =LocalDate.of(2022,11,10);
        stock3.setStockTime(localTime3);
        stock3.setStockPrice(115000l);
        stock3.setStockPicture("https://login.kg/image/cache/catalog/new/Notebook/Xiaomi/Pro%20X%2015/4-500x500.jpg");
        stockService.save(stock3);

        Stock stock2 = new Stock();
        stock2.setName("Iphone 13 pro max");
        stock2.setStock(10l);
        LocalDate localTime2 =LocalDate.of(2022,9,12);
        stock2.setStockTime(localTime2);
        stock2.setStockPrice(70000l);
        stock2.setStockPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw0utNIi4XIvaTEbiKEvBDtXi1tDBF2uGyNg&usqp=CAU");
        stockService.save(stock2);

    }
}
