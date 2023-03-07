# Backend

Phần backend của hệ thống được xây dựng để hỗ trợ các ứng dụng di động và webapp.  Là nơi xử lý các tác vụ phía server, cung cấp các API để cho phép các ứng dụng kết nối và truy cập vào các dữ liệu cần thiết từ phía client. Đóng vai trò như là trung tâm điều hành và quản lý tất cả các hoạt động trong hệ thống.

### Kỹ thuật nổi bật:

- `Event driven architecture`
- `Event sourcing`
- `CQRS`
- `Saga pattern (Orchestration)`

### **Prerequisites**

- `Java 16`
- `Docker`
- `Docker-compose`

### 1, Technology

- Core: SpringBoot, Spring Cloud, Axon Framework
- Security: Spring Security, Oath2
- Persistence layer framework: Jpa
- Database / storage: MySQL, Elasticsearch, Redis
- Message queue: Kafka
- Log management: Logback
- Deployment: Docker
- Monitoring: Prometheus, Grafana, Zipkin

### 2, Directory structure
```
├ ——-**bookstore-backend**---------------------------- Thư mục cha, quản lý phụ thuộc
 │  │
 │ ├ —— common-------------------------------- Dữ liệu, class dùng chung

 │  │
 │ ├ —— api-gateway-service-------------------------------- Định tuyến request
 │  │
 │ ├ —— discovery-service------------------------- Điều phối services
 │  │
 │ ├ —— user-service------------------------ quản lý đăng nhập, thông tin user
 │  │
 │ ├ —— catalog-service----------------------- Quản lý danh mục sản phẩm 
 │  │
 │ ├ —— notification-service-------------------------- quản lý thông báo 
 │  │
 │ ├ —— order-service------------------------ quản lý đơn hàng, giỏ hàng
 │  │
 │ ├ —— payment-service-------------------------- liên kết thanh toán
 │  │
 │ ├ —— search-service--------------------------- tìm kiếm sản phẩm ở catalog-services
```
### 3, Kiến trúc ứng dụng

![package_diagram_4.1.2.drawio.png](Backend%202b25b07a7332475ebd51b9b8f78a5a4f/package_diagram_4.1.2.drawio.png)
