CREATE TABLE `UserInfo`(
    `UserID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(255) NOT NULL,
    `lastName` VARCHAR(255) NOT NULL,
    `Address` INT NOT NULL,
    `Email` VARCHAR(255) NOT NULL,
    `Phone` DOUBLE NOT NULL,
    `dateRegistered` DATE NOT NULL,
    `dateOfBirth` INT NOT NULL
);
ALTER TABLE
    `UserInfo` ADD PRIMARY KEY `userinfo_userid_primary`(`UserID`);
CREATE TABLE `Workers`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `MemberID` INT NOT NULL,
    `workTitle` INT NOT NULL,
    `Payment` INT NOT NULL
);
ALTER TABLE
    `Workers` ADD PRIMARY KEY `workers_id_primary`(`id`);
CREATE TABLE `Departments`(
    `DepartmentID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `departmentName` INT NOT NULL,
    `managerID` INT NOT NULL,
    `column_5` INT NOT NULL
);
ALTER TABLE
    `Departments` ADD PRIMARY KEY `departments_departmentid_primary`(`DepartmentID`);
CREATE TABLE `Tithe Collection`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `totalCollected` INT NOT NULL,
    `dateCollected` DATE NOT NULL
);
ALTER TABLE
    `Tithe Collection` ADD PRIMARY KEY `tithe collection_id_primary`(`id`);
CREATE TABLE `Tithe / Offering`(
    `TitheID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `UserID` INT NOT NULL,
    `totalTithe` INT NOT NULL,
    `totalOffering` INT NOT NULL,
    `dateCollected` DATE NOT NULL
);
ALTER TABLE
    `Tithe / Offering` ADD PRIMARY KEY `tithe / offering_titheid_primary`(`TitheID`);
CREATE TABLE `Offering`(
    `OfferingID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `totalCollected` INT NOT NULL,
    `dateCollected` INT NOT NULL
);
ALTER TABLE
    `Offering` ADD PRIMARY KEY `offering_offeringid_primary`(`OfferingID`);
CREATE TABLE `Attendance`(
    `AttendanceID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `UserID` INT NOT NULL,
    `dateOfAttendance` DATE NOT NULL
);
ALTER TABLE
    `Attendance` ADD PRIMARY KEY `attendance_attendanceid_primary`(`AttendanceID`);
CREATE TABLE `Roles`(
    `RoleID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `roleName` INT NOT NULL,
    `UserID` INT NOT NULL
);
ALTER TABLE
    `Roles` ADD PRIMARY KEY `roles_roleid_primary`(`RoleID`);
CREATE TABLE `Visitors`(
    `UserID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `visitorName` INT NOT NULL,
    `Email` INT NOT NULL,
    `visitDate` INT NOT NULL
);
ALTER TABLE
    `Visitors` ADD PRIMARY KEY `visitors_userid_primary`(`UserID`);
CREATE TABLE `Users`(
    `UserID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `userName` INT NOT NULL,
    `password` INT NOT NULL
);
ALTER TABLE
    `Users` ADD PRIMARY KEY `users_userid_primary`(`UserID`);
CREATE TABLE `MembersOfChristAmbassadors`(
    `UserID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `lastName` INT NOT NULL,
    `phone` INT NOT NULL,
    `dateJoined` DATE NOT NULL
);
ALTER TABLE
    `MembersOfChristAmbassadors` ADD PRIMARY KEY `membersofchristambassadors_userid_primary`(`UserID`);
CREATE TABLE `Announcements`(
    `AnnouncementID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `UserID` INT NOT NULL,
    `message` VARCHAR(255) NOT NULL,
    `date` DATE NOT NULL
);
ALTER TABLE
    `Announcements` ADD PRIMARY KEY `announcements_announcementid_primary`(`AnnouncementID`);
ALTER TABLE
    `Tithe / Offering` ADD CONSTRAINT `tithe / offering_userid_foreign` FOREIGN KEY(`UserID`) REFERENCES `MembersOfChristAmbassadors`(`UserID`);
ALTER TABLE
    `Roles` ADD CONSTRAINT `roles_userid_foreign` FOREIGN KEY(`UserID`) REFERENCES `MembersOfChristAmbassadors`(`UserID`);
ALTER TABLE
    `Attendance` ADD CONSTRAINT `attendance_userid_foreign` FOREIGN KEY(`UserID`) REFERENCES `MembersOfChristAmbassadors`(`UserID`);
ALTER TABLE
    `Announcements` ADD CONSTRAINT `announcements_userid_foreign` FOREIGN KEY(`UserID`) REFERENCES `MembersOfChristAmbassadors`(`UserID`);