-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2025 at 04:48 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pertambangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `ID_Karyawan` varchar(255) NOT NULL,
  `Nama_Karyawan` varchar(255) DEFAULT NULL,
  `Jabatan` varchar(255) DEFAULT NULL,
  `Alamat_Karyawan` varchar(255) DEFAULT NULL,
  `No_Telp_Karyawan` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`ID_Karyawan`, `Nama_Karyawan`, `Jabatan`, `Alamat_Karyawan`, `No_Telp_Karyawan`, `Password`) VALUES
('345', 'Iki', 'Kepala Lapangan', 'Gatot', '0812', 'apayak'),
('346', 'Michael', 'Kepala Lapangan', 'Gatot', '0813', 'apaya');

-- --------------------------------------------------------

--
-- Table structure for table `konsumen`
--

CREATE TABLE `konsumen` (
  `ID_Konsumen` varchar(255) NOT NULL,
  `Nama_Perusahaan` varchar(255) DEFAULT NULL,
  `Alamat_Perusahaan` varchar(255) DEFAULT NULL,
  `No_Telp_Perusahaan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `konsumen`
--

INSERT INTO `konsumen` (`ID_Konsumen`, `Nama_Perusahaan`, `Alamat_Perusahaan`, `No_Telp_Perusahaan`) VALUES
('0384', 'KPT Company', 'Suldam', '0813'),
('1234', 'Iki Company', 'Gatot', '0812');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `ID_Pemesanan` varchar(255) NOT NULL,
  `Tanggal_Pemesanan` varchar(255) DEFAULT NULL,
  `ID_Konsumen` varchar(255) DEFAULT NULL,
  `ID_Karyawan` varchar(255) DEFAULT NULL,
  `Notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`ID_Pemesanan`, `Tanggal_Pemesanan`, `ID_Konsumen`, `ID_Karyawan`, `Notes`) VALUES
('123', '123', '123', '123', '123'),
('345', '34', '345', '345', 'Mantap');

-- --------------------------------------------------------

--
-- Table structure for table `produksi`
--

CREATE TABLE `produksi` (
  `ID_Produksi` varchar(255) NOT NULL,
  `ID_Pemesanan` varchar(255) DEFAULT NULL,
  `Tanggal_Produksi` varchar(255) DEFAULT NULL,
  `ID_Wilayah` varchar(255) DEFAULT NULL,
  `ID_Produk` varchar(255) DEFAULT NULL,
  `Jumlah_Produksi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produksi`
--

INSERT INTO `produksi` (`ID_Produksi`, `ID_Pemesanan`, `Tanggal_Produksi`, `ID_Wilayah`, `ID_Produk`, `Jumlah_Produksi`) VALUES
('123', '123', '123', '123', '123', '123'),
('345', '345', '13', '345', '345', '13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`ID_Karyawan`);

--
-- Indexes for table `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`ID_Konsumen`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`ID_Pemesanan`);

--
-- Indexes for table `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`ID_Produksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
