-- Tạo cơ sở dữ liệu
CREATE DATABASE QUANLYBAOHIEM;
GO

-- Sử dụng cơ sở dữ liệu vừa tạo
USE QUANLYBAOHIEM;
GO

-- Tạo bảng Users
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY để tự động tăng
    Username NVARCHAR(50) NOT NULL UNIQUE,
    Pass NVARCHAR(255) NOT NULL,
    Roles NVARCHAR(20) 
);
GO

-- Tạo bảng Customers
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY để tự động tăng
    UserID INT,
    FullName NVARCHAR(100),
    Phone NVARCHAR(15),
    Address NVARCHAR(255),
    Email NVARCHAR(100),
    CreatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);
GO
select*from Customers
ALTER TABLE Customers
ADD Age INT;  -- thêm trường Age để lưu tuổi của khách hàng
ALTER TABLE Customers
DROP COLUMN Email;




CREATE TABLE Services (
    ServiceID INT PRIMARY KEY,
    ServiceName NVARCHAR(100),
    Description NVARCHAR(255),
    CreatedAt DATETIME DEFAULT GETDATE()
);
GO

-- Tạo bảng Policies
CREATE TABLE Policies (
    PolicyID INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY để tự động tăng
    PolicyName NVARCHAR(100) NOT NULL UNIQUE,
    CoverageAmount DECIMAL(10, 2) NOT NULL,
    
    Duration INT NOT NULL, -- Duration in months
    ServiceID INT,
    CreatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (ServiceID) REFERENCES Services(ServiceID)    
);
GO
ALTER TABLE Policies
DROP COLUMN PremiumAmount ;
DROP TABLE Services
Drop table Policies
Drop table CustomerPolicies
ALTER TABLE Services
DROP COLUMN ServiceID;
drop table Services


-- Tạo bảng CustomerPolicies
CREATE TABLE CustomerPolicies (
    CustomerPolicyID INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY để tự động tăng
    CustomerID INT,
    PolicyID INT,
    StartDate DATETIME,
    EndDate DATETIME,
    Status NVARCHAR(20) NOT NULL CHECK (Status IN ('active', 'inactive')),
    CreatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY (PolicyID) REFERENCES Policies(PolicyID) ON DELETE CASCADE
);
GO
ALTER TABLE CustomerPolicies ADD Duration INT;

ALTER TABLE CustomerPolicies
ADD PolicyList NVARCHAR(255),      -- Lưu danh sách các loại bảo hiểm
    
    Duration INT,                  -- Thời hạn bảo hiểm (tháng)
    ProjectedPremium DECIMAL(10, 2);  -- Mức phí bảo hiểm dự kiến


-- Thêm dữ liệu mẫu vào bảng Users
INSERT INTO Users (Username, Pass, Roles)
VALUES ('test', '1234', 'admin');
GO

-- Kiểm tra dữ liệu trong bảng Users
SELECT * FROM Users
SELECT Username, Pass, Roles FROM Users;

SELECT * FROM Services;
SELECT * FROM CustomerPolicies;
ALTER TABLE CustomerPolicies
ADD UserID INT;
SELECT * FROM Policies
-- Cập nhật khóa ngoại cho cột UserID trong bảng CustomerPolicies

ALTER TABLE CustomerPolicies
ADD CONSTRAINT FK_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE NO ACTION;
GO
SELECT PolicyName FROM Policies 
CREATE TABLE CustomerInsuranceInfo (
    InsuranceInfoID INT PRIMARY KEY IDENTITY(1,1), -- ID tự động tăng
    CustomerID INT NOT NULL,                       -- ID khách hàng
    FullName NVARCHAR(100) NOT NULL,               -- Tên khách hàng
    PolicyID INT NOT NULL,                         -- Gói bảo hiểm
    StartDate DATETIME NOT NULL,                   -- Ngày bắt đầu
    EndDate DATETIME NOT NULL,                     -- Ngày kết thúc
    Status NVARCHAR(20) NOT NULL CHECK (Status IN ('active', 'inactive')), -- Trạng thái
    CreatedAt DATETIME DEFAULT GETDATE(),          -- Ngày tạo
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY (PolicyID) REFERENCES Policies(PolicyID) ON DELETE CASCADE
);

select*from CustomerInsuranceInfo