-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2017 at 04:49 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `noticeboard`
--

-- --------------------------------------------------------

--
-- Table structure for table `channel`
--

CREATE TABLE `channel` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Batch` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `channel`
--

INSERT INTO `channel` (`Id`, `UserId`, `Batch`) VALUES
(1, 14, '14'),
(2, 2, '16'),
(3, 2, '14'),
(4, 16, '15'),
(5, 16, '14'),
(6, 2, '14'),
(7, 2, '17'),
(8, 17, '16'),
(9, 17, '14'),
(10, 16, '16'),
(11, 2, '16');

-- --------------------------------------------------------
--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `NoticeId` int(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Description` varchar(250) NOT NULL,
  `NoticeType` varchar(30) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`NoticeId`, `Title`, `Description`, `NoticeType`, `UserID`, `Date`) VALUES
(1, 'class canceled declare', 'today has no class anymore', 'Only for Subscriber', 1, '2017-04-10 12:50:16'),
(2, 'exam', 'it shod changed', 'For all', 1, '2017-04-10 13:31:56'),
(3, 'no class', 'nextday', 'rouine', 2, '2017-03-25 17:14:47'),
(4, 'class won\'t be held', 'phy class will not held', 'Routine', 1, '2017-03-28 06:35:56'),
(5, 'labtest', 'tomorrow', 'For all', 2, '2017-04-07 14:28:30'),
(6, 'lab canceled', 'today dld lab has been canceled', 'update', 2, '2017-03-27 08:10:23'),
(7, 'no class', 'next day has no class', 'Routine', 2, '2017-03-27 08:16:20'),
(8, 'no', 'class', 'Routine', 2, '2017-03-27 08:18:22'),
(9, 'DS Class', 'Taken By Rafiq Sir', 'Class', 8, '2017-03-27 09:11:53'),
(10, 'lab', 'next day ds lab', 'Routine', 2, '2017-03-27 11:06:55'),
(11, 'wait', 'plz wait for confirmation', 'waiting', 2, '2017-03-27 11:13:57'),
(12, 'apl', 'Tuesday ', 'arif', 11, '2017-03-27 12:06:56'),
(13, 'huhh', 'we won the match', 'Game', 7, '2017-03-27 12:11:03'),
(14, 'Whatever', 'No Need', 'For all\r\n', 14, '2017-04-05 12:13:27'),
(15, 'I', 'hello', 'Only my batch', 2, '2017-04-10 14:30:59'),
(16, 'hi boys', 'okk', 'Only my batch', 2, '2017-04-10 13:56:54'),
(17, 'player', 'no game', 'Game', 7, '2017-03-30 16:22:21'),
(18, 'hi', 'guys', 'For all', 15, '2017-04-05 12:19:31'),
(19, 'little', 'boys', 'no', 7, '2017-03-30 18:48:19'),
(20, 'sleep', 'enough', 'no', 7, '2017-03-30 20:24:16'),
(21, 'huge', 'work', 'today', 9, '2017-03-30 20:33:50'),
(22, 'gamming', 'game jam', 'Project', 10, '2017-03-31 12:25:21'),
(23, 'no title', 'class will be held', '13', 10, '2017-04-04 14:19:28'),
(24, 'exam', 'good', '16', 2, '2017-04-04 14:18:21'),
(25, 'ds test', 'nextday', 'For all', 10, '2017-04-05 12:34:38'),
(26, 'bangladesh won', 'yes..won won the game', 'For all', 16, '2017-04-06 14:07:41'),
(27, 'exam my god', 'not good news okk', 'Only for Subscriber', 2, '2017-04-10 13:56:14'),
(28, 'exam ', 'not good news', 'Only for Subscriber', 2, '2017-04-10 14:36:05');

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `NoticeId` int(11) NOT NULL,
  `Seen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`Id`, `UserId`, `NoticeId`, `Seen`) VALUES
(1, 2, 8, 1),
(2, 2, 7, 1),
(22, 2, 15, 1),
(23, 7, 7, 1),
(24, 2, 14, 1),
(25, 2, 13, 1),
(26, 7, 16, 1),
(27, 7, 14, 1),
(28, 2, 17, 1),
(29, 2, 16, 1),
(30, 2, 11, 1),
(31, 2, 10, 1),
(32, 7, 19, 1),
(33, 2, 19, 1),
(34, 2, 9, 1),
(35, 2, 3, 1),
(36, 2, 3, 1),
(37, 7, 11, 1),
(38, 7, 17, 1),
(39, 7, 10, 1),
(40, 7, 13, 1),
(41, 7, 15, 1),
(42, 7, 18, 1),
(43, 9, 20, 1),
(44, 9, 19, 1),
(45, 9, 18, 1),
(46, 10, 21, 1),
(47, 10, 20, 1),
(48, 10, 19, 1),
(49, 10, 18, 1),
(50, 10, 17, 1),
(51, 10, 16, 1),
(52, 10, 16, 1),
(53, 2, 23, 1),
(54, 2, 22, 1),
(55, 2, 20, 1),
(56, 2, 6, 1),
(57, 2, 5, 1),
(58, 2, 1, 1),
(59, 2, 27, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserId` int(11) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Dicipline` varchar(30) NOT NULL,
  `Batch` int(11) NOT NULL,
  `University` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `FirstName`, `LastName`, `Email`, `Password`, `Dicipline`, `Batch`, `University`) VALUES
(1, 'avigit', 'dutto', 'avigit@gmail.com', '140212', 'cse', 14, 'ku'),
(2, 'lotif', 'limon', 'lotif@gmail.com', '160212', 'cse', 16, 'ku'),
(3, 'manna', 'khan', 'manna@gmail.com', '160204', 'cse', 16, 'ku'),
(4, 'fahim', 'rahman', 'fahim@gmail.com', '160215', 'css', 16, 'ku'),
(5, 'arjuman', 'sresto', 'arju@gmail.com', '160214', 'cse', 16, 'ku'),
(6, 'fahim', 'khan', 'fahim@gmail.com', '140217', 'cse', 14, 'ku'),
(7, 'foysal', 'islam', 'foysal@gmail.com', '160227', 'cse', 16, 'ku'),
(8, 'Mesbah', 'Ur Rahman', 'niloykpc123@gmail.com', '99999999n', 'CSE', 16, 'KU'),
(9, 'bappy', 'b', 'bappy@gmail.com', '160219', 'cse', 16, 'ku'),
(10, 'Foysal', 'Ahmed', 'foysal@gmail.com', '130227', 'cse', 13, 'ku'),
(11, 'arifut', 'rahman', 'arifurcseku16@gmail.com', '01775328037', ' cse', 16, 'khulna university'),
(12, 'Samiha', 'Ahmed', 'samiha@gmail.com', '160209', 'CSE', 16, 'KU'),
(13, 'Maain', 'Haque', 'maain@gmail.com', '160237', 'CSE', 16, 'KU'),
(14, 'Binayok', 'Roy', 'roy@gmail.com', '130222', 'cse', 13, 'ku'),
(15, 'Ajom', 'khan', 'ajom@gmail.com', '162512', 'mcj', 16, 'ku'),
(16, 'tanvir', 'hasan', 'tanvir@gmail.com', '120212', 'cse', 12, 'ku'),
(17, 'poricoy', 'mondal', 'poricoy@gmail.com', '120201', 'cse', 12, 'ku');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`NoticeId`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `UserId` (`UserId`),
  ADD KEY `NoticeId` (`NoticeId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channel`
--
ALTER TABLE `channel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `NoticeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `subscription`
--
ALTER TABLE `subscription`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `channel`
--
ALTER TABLE `channel`
  ADD CONSTRAINT `channel_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notice`
--
ALTER TABLE `notice`
  ADD CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `subscription_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subscription_ibfk_2` FOREIGN KEY (`NoticeId`) REFERENCES `notice` (`NoticeId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

