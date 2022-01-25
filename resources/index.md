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
	  * Download the VM image file, [comp378VM.ova](https://dickinson0-my.sharepoint.com/:u:/g/personal/jmac_dickinson_edu/EQSsBh04sspDoldjO7RoU6sBZ5k0QlMb444-a0REQrPdXA?e=JTfYUd)
	  * Open the VirtualBox app, then choose File &#124; Import Appliance and pick `comp378VM.ova`
	  * The [username and password for this virtual
        machine](https://lms.dickinson.edu/mod/page/view.php?id=1080082)
        are available on Moodle.
* accessing phpMyAdmin:
  - on Windows
    - Run XAMPP control panel as administrator
    - Start Apache and MySQL
    - Click on Admin for MySQL
  - on Ubuntu
    - open Terminal, enter `sudo /opt/lampp/manager-linux-x64.run`
    - on Manage Servers tab, choose Start All
    - open FireFox, visit http://localhost, click on phpMyAdmin (top right)
* importing the `wine` database:
  - download [wine.sql](../sql/wine.sql)
  - in phpMyAdmin:
    * click the Home icon, then New
	* enter `wine` as database name, click Create
	* click Import &#124; Choose File, then select `wine.sql`
	* click Go (bottom right)
* querying the `wine` database (Do this in your own phpMyAdmin or at
  the [textbook online playground](https://www.pdbmbook.com/playground)):
  - click on SQL
  - enter `SELECT * FROM supplier`, click Go (bottom right)
  - for a more interesting example, try `SELECT * FROM supplier WHERE supcity='San Francisco'`

* [chapter 1 textbook slides](https://www.pdbmbook.com/vault/Chapter%20Fundamental%20Concepts%20of%20Database%20Management.pdf/access): especially slides 4-13, 17-18, 21

----
Last modified: Tue Jan 25 17:23:47 UTC 2022 by jmac.
