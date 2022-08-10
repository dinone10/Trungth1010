USE [master]
GO
/****** Object:  Database [FoodManagement]    Script Date: 3/12/2022 9:49:18 PM ******/
CREATE DATABASE [FoodManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FoodManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\FoodManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'FoodManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\FoodManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [FoodManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FoodManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FoodManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FoodManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FoodManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FoodManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FoodManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [FoodManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FoodManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FoodManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FoodManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FoodManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FoodManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FoodManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FoodManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FoodManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FoodManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FoodManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FoodManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FoodManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FoodManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FoodManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FoodManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FoodManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FoodManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FoodManagement] SET  MULTI_USER 
GO
ALTER DATABASE [FoodManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FoodManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FoodManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FoodManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [FoodManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [FoodManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [FoodManagement] SET QUERY_STORE = OFF
GO
USE [FoodManagement]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [nvarchar](50) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [int] NOT NULL,
	[orderDate] [nvarchar](50) NULL,
	[total] [nvarchar](50) NULL,
	[userID] [nvarchar](50) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrderDetail]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetail](
	[detailID] [int] NOT NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[orderID] [int] NOT NULL,
	[productID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblOrderDetail] PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProduct](
	[productID] [nvarchar](50) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[image] [nvarchar](max) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[categoryID] [nvarchar](50) NULL,
	[importDate] [nvarchar](50) NULL,
	[usingDate] [nvarchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblProduct] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [nvarchar](50) NOT NULL,
	[roleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRoles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 3/12/2022 9:49:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[birthday] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName], [status]) VALUES (N'T001', N'Rau lá các loại ', 1)
INSERT [dbo].[tblCategory] ([categoryID], [categoryName], [status]) VALUES (N'T002', N'Rau củ các loại', 1)
INSERT [dbo].[tblCategory] ([categoryID], [categoryName], [status]) VALUES (N'T003', N'Nấm tươi các loại', 1)
INSERT [dbo].[tblCategory] ([categoryID], [categoryName], [status]) VALUES (N'T004', N'Trái cây tươi ngon', 1)
GO
INSERT [dbo].[tblOrder] ([orderID], [orderDate], [total], [userID], [status]) VALUES (1, N'2022-3-12', N'1', N'admin', 0)
INSERT [dbo].[tblOrder] ([orderID], [orderDate], [total], [userID], [status]) VALUES (2, N'2022-03-12', N'8500', N'SE150449', 0)
INSERT [dbo].[tblOrder] ([orderID], [orderDate], [total], [userID], [status]) VALUES (3, N'2022-03-12', N'8500', N'admin', 0)
GO
INSERT [dbo].[tblOrderDetail] ([detailID], [price], [quantity], [orderID], [productID]) VALUES (1, 8500, 1, 2, N'F002')
INSERT [dbo].[tblOrderDetail] ([detailID], [price], [quantity], [orderID], [productID]) VALUES (2, 8500, 1, 3, N'F002')
GO
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F001', N'Rau Muống', N'https://cdn.tgdd.vn/Products/Images/8820/223346/bhx/rau-muong-nuoc-baby-tui-300g-202011071625597368.jpg', 12000, 10, N'T001', N'2022-01-05', N'2022-05-05', 0)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F002', N'Bí Xanh', N'https://cdn.tgdd.vn/Products/Images/8785/220461/bhx/bi-xanh-tui-1kg-202011092052402369.jpg', 8500, 3, N'T002', N'2022-01-05', N'2022-05-05', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F003', N'Cà Chua', N'https://cdn.tgdd.vn/Products/Images/8785/271472/bhx/ca-chua-tui-1kg-10-12-trai-202202171401233459.jpg', 28000, 10, N'T002', N'2022-01-05', N'2022-05-10', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F004', N'Nấm đùi gà', N'https://cdn.tgdd.vn/Products/Images/8820/228921/bhx/nam-dui-ga-vi-200g-202011071708469792.jpg', 26000, 5, N'T003', N'2022-01-05', N'2022-05-15', 0)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F005', N'Măng tây', N'https://cdn.tgdd.vn/Products/Images/8820/222783/bhx/mang-tay-bo-200g-202012082233244193.jpg', 25000, 25, N'T001', N'2022-01-05', N'2022-05-05', 0)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F006', N'Kim Chi', N'https://cdn.tgdd.vn/Products/Images/7459/225684/bhx/kim-chi-cai-thao-cat-lat-cj-food-ong-kims-hop-300g-202107200032410191.jpg', 27500, 10, N'T001', N'2022-01-05', N'2022-05-05', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F007', N'Cam vàng', N'https://cdn.tgdd.vn/Products/Images/8788/202933/bhx/cam-vang-valencia-uc-hop-1kg-4-5-trai-202101271645521884.jpg', 49000, 5, N'T004', N'2022-01-05', N'2022-05-10', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F008', N'Cam sành', N'https://cdn.tgdd.vn/Products/Images/8788/235006/bhx/cam-sanh-tui-1kg-3-4-trai-202203101547095271.jpg', 39000, 10, N'T004', N'2022-01-05', N'2022-05-10', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F009', N'Nấm bào ngư', N'https://cdn.tgdd.vn/Products/Images/8820/226957/bhx/nam-bao-ngu-xam-bich-300g-202009300011236390.jpg', 18500, 5, N'T003', N'2022-01-05', N'2022-05-05', 0)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F010', N'Khổ qua', N'https://cdn.tgdd.vn/Products/Images//8785/226878/bhx/images/kho-qua-tui-500g-202010011953395679.jpg', 13000, 5, N'T002', N'2022-01-05', N'2022-05-10', 1)
INSERT [dbo].[tblProduct] ([productID], [productName], [image], [price], [quantity], [categoryID], [importDate], [usingDate], [status]) VALUES (N'F111', N'Ca phao', N'1', 1, 1, N'T001', N'2001-1-1', N'2001-3-3', 1)
GO
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'admin', N'trung', N'1', N'US', N'553 LiÃªn PhÆ°á»ng', N'2001-1-1', N'0766884855', N'dinone@gmail.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'afsad', N'conmemay', N'1', N'US', N'aaaaaaaaa', N'aaaaaa', N'aaaa', N'aaaaa@gmail.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'dinone', N'trungne', N'1', N'US', N'111 Lien Phuong', N'2001-1-1', N'0788997766', N'congconcac@gmail.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'dinone111', N'Trung Tran', N'1', N'US', N'999 Lien Phuong', N'2001-1-1', N'0909090909', N'dinonene@gmail.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'hihihi', N'hahaha', N'1', N'US', N'333 Lien Phuong', N'2001-1-1', N'1', N'haha@gmaill.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE00000', N'Pham Quang Van', N'1', N'US', N'111 Lien Phuong', N'2001-1-1', N'0909090909', N'vanpham@gmail.com', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE111111', N'Dinone', N'1', N'US', N'111 Lien Phuong', N'1', N'1', N'1', NULL)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE150436	', N'Hoàng Văn Hòa', N'1', N'AD', N'555 Liên Phường', N'2001-05-05', N'345678913', N'	hoahqse150436@fpt.edu.vn', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE150445', N'Phạm Hưng Phát', N'1', N'AD', N'111 Liên Phường', N'2001-03-03', N'897654314', N'	phatphse150445@fpt.edu.vn', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE150449', N'Trương Minh Tuệ', N'1', N'US', N'333 Liên Phường', N'2001-04-04', N'765894567', N'	tuetmse150449@fpt.edu.vn', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE150485', N'Trần Hiếu Trung', N'1', N'AD', N'269 Liên Phường', N'2001-10-10', N'766884855', N'ht10102001@gmail.com', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [address], [birthday], [phone], [email], [status]) VALUES (N'SE150492', N'Lê Đình Linh Nguyên', N'1', N'US', N'269 Liên Phường', N'2001-01-01', N'134567815', N'	nguyenldlse150492@fpt.edu.vn', 1)
GO
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblOrder_tblUsers] FOREIGN KEY([userID])
REFERENCES [dbo].[tblUsers] ([userID])
GO
ALTER TABLE [dbo].[tblOrder] CHECK CONSTRAINT [FK_tblOrder_tblUsers]
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetail_tblOrder] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderDetail] CHECK CONSTRAINT [FK_tblOrderDetail_tblOrder]
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetail_tblProduct] FOREIGN KEY([productID])
REFERENCES [dbo].[tblProduct] ([productID])
GO
ALTER TABLE [dbo].[tblOrderDetail] CHECK CONSTRAINT [FK_tblOrderDetail_tblProduct]
GO
ALTER TABLE [dbo].[tblProduct]  WITH CHECK ADD  CONSTRAINT [FK_tblProduct_tblCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblProduct] CHECK CONSTRAINT [FK_tblProduct_tblCategory]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRoles] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRoles]
GO
USE [master]
GO
ALTER DATABASE [FoodManagement] SET  READ_WRITE 
GO
