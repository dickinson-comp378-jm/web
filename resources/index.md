# Detailed schedule




## Class 1

* Overview of the course. 
* Discussion of: why do we need databases?
* Instructions on XAMPP installation:
  - The recommended database software for this course is the XAMPP
    package. This can be downloaded and installed on Windows, Linux,
    and MacOS from the [XAMPP web
    page](https://www.apachefriends.org/index.html) at
    apachefriends.org.
  - If desired, you can use the iMacs in Tome with XAMPP. You will
    need to create a virtual machine on one of the iMacs then use
    XAMPP within that virtual machine. A virtual machine image is
    provided to help you with this. Details:
	  * under construction...
* accessing phpMyAdmin:
  - Runs XAMPP control panel as administrator
  - Start Apache and MySQL
  - Click on Admin for MySQL
* importing the `wine` database:
  - download [wine.sql](../sql/wine.sql)
  - in phpMyAdmin:
    * click the Home icon, then New
	* enter `wine` as database name, click Create
	* click Import | Choose File, then select `wine.sql`
	* click Go (bottom right)
* querying the `wine` database:
  - click on SQL
  - enter `SELECT * FROM supplier`, click Go (bottom right)
  - for a more interesting example, try `SELECT * FROM supplier WHERE supcity='San Francisco'`

* [chapter 1 textbook slides](https://www.pdbmbook.com/vault/Chapter%20Fundamental%20Concepts%20of%20Database%20Management.pdf/access)

----
Last modified: Sat Jan 22 19:32:57 UTC 2022 by jmac.
