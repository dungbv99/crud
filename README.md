READ ME
SHOPPING ONLINE


Hướng dẫn chạy project

Bước 1: Tạo database:
Tạo database shoppingwithspring:
        create database shoppingwithspring
        
Bước 2:Tạo bảng persistent_logins:

CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);

(Bảng duy nhất phải tạo để lưu tooken duy trì đăng nhập các bảng khác sẽ được tự tạo với hibernate)

Bước 3: sửa đổi username và password trong application.properties thành username và password trong mysql của bạn
![abc](https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwic8dOBoKHmAhUigUsFHUAaAOAQjRx6BAgBEAQ&url=https%3A%2F%2Fsites.google.com%2Fsite%2Fhinhanhdep24h%2F&psig=AOvVaw0wB1c9Ea-g_FrAUX8uWSQ8&ust=1575729514102883)

Bước 4 chạy project:

Lệnh dịch file jar:
        mvnw clean package

Lệnh chạy chương trình:

        java -jar target\hello.jar         (window)
        java -jar target/hello.jar         (linux)
        
        
Sau khi chạy xong project:
Các bảng 
