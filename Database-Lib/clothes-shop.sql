USE [master]
GO
/****** Object:  Database [ClothesShop]    Script Date: 14/07/2022 11:05:23 CH ******/
CREATE DATABASE [ClothesShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ClothesShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\ClothesShop.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ClothesShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\ClothesShop_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ClothesShop] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ClothesShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ClothesShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ClothesShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ClothesShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ClothesShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ClothesShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [ClothesShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ClothesShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ClothesShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ClothesShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ClothesShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ClothesShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ClothesShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ClothesShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ClothesShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ClothesShop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ClothesShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ClothesShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ClothesShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ClothesShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ClothesShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ClothesShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ClothesShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ClothesShop] SET RECOVERY FULL 
GO
ALTER DATABASE [ClothesShop] SET  MULTI_USER 
GO
ALTER DATABASE [ClothesShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ClothesShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ClothesShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ClothesShop] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ClothesShop', N'ON'
GO
USE [ClothesShop]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 14/07/2022 11:05:23 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](30) NOT NULL,
	[pass] [varchar](30) NOT NULL,
	[discount] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 14/07/2022 11:05:23 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 14/07/2022 11:05:23 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[discount] [float] NOT NULL,
	[category_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [pass], [discount]) VALUES (N'admin', N'trung123', 20)
INSERT [dbo].[Account] ([username], [pass], [discount]) VALUES (N'cong', N'cong123', 30)
INSERT [dbo].[Account] ([username], [pass], [discount]) VALUES (N'hieutrung', N'htrung', 35)
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name]) VALUES (1, N'Shirt')
INSERT [dbo].[Category] ([id], [name]) VALUES (2, N'Pant')
INSERT [dbo].[Category] ([id], [name]) VALUES (3, N'Jacket')
INSERT [dbo].[Category] ([id], [name]) VALUES (4, N'Hoodie')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (1, N'Shirt 1', 204.99, 0.1, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (2, N'Shirt 2', 73.94, 0.05, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (3, N'Shirt 3', 74.11, 0.05, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (4, N'Shirt 4', 52.73, 0, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (5, N'Shirt 5', 171.13, 0.15, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (6, N'Shirt 6', 140.55, 0.1, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (7, N'Shirt 7', 56.01, 0.1, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (8, N'Shirt 8', 48.17, 0.1, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (9, N'Shirt9', 62.03, 0, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (10, N'Shirt 10', 88.19, 0.1, 1)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (11, N'Pant 11', 20.31, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (12, N'Pant 12', 96.47, 0.15, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (13, N'Pant 13', 155.58, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (14, N'Pant 14', 204.26, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (15, N'Pant 15', 148.25, 0.1, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (16, N'Pant 16', 209.9, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (17, N'Pant 17', 104.29, 0.1, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (18, N'Pant 18', 146.36, 0, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (19, N'Pant 19', 154.76, 0.15, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (20, N'Pant 20', 135.82, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (21, N'Pant 21', 158.46, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (22, N'Pant 22', 165.89, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (23, N'Pant 23', 95.7, 0.1, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (24, N'Pant 24', 80.16, 0.05, 2)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (25, N'Jacket 25', 19.25, 0.1, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (26, N'Jacket  26', 171.36, 0.1, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (27, N'Jacket  27', 35.08, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (28, N'Jacket  28', 57.92, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (29, N'Jacket  29', 157.81, 0, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (30, N'Jacket  30', 151, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (31, N'Jacket  31', 126.34, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (32, N'Jacket  32', 170.23, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (33, N'Jacket  33', 136.5, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (34, N'Jacket  34', 24.68, 0.1, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (35, N'Jacket  35', 88.71, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (36, N'Jacket  36', 190.43, 0.05, 3)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (37, N'Hoodie 37', 14, 0.05, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (38, N'Hoodie 38', 206.57, 0.1, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (39, N'Hoodie 39', 163.48, 0, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (40, N'Hoodie 40', 92.3, 0, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (41, N'Hoodie 41', 168.69, 0.1, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (42, N'Hoodie 42', 117.89, 0.05, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (43, N'Hoodie 43', 56.34, 0.05, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (44, N'Hoodie 44', 158.61, 0, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (45, N'Hoodie 45', 209.96, 0.05, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (46, N'Hoodie 46', 176.24, 0, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (47, N'Hoodie 47', 174.28, 0.05, 4)
INSERT [dbo].[Product] ([id], [name], [price], [discount], [category_id]) VALUES (48, N'Hoodie 48', 70.65, 0, 4)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
USE [master]
GO
ALTER DATABASE [ClothesShop] SET  READ_WRITE 
GO
