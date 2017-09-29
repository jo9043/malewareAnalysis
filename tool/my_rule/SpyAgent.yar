rule SpyAgent
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection arabian spyware which records call and gathers user information which is later sent to a remot c&c"
	ref = "https://blogs.mcafee.com/mcafee-labs/android-spyware-targets-security-job-seekers-in-saudi-arabia/"

	strings:
	$phone = "0597794205"
	$caption = "New victim arrived"
	$cc = "http://ksa-sef.com/Hack%20Mobaile/ADDNewSMS.php"
	$cc0 = "http://ksa-sef.com/Hack%20Mobaile/AddAllLogCall.php"
	$cc1= "http://ksa-sef.com/Hack%20Mobaile/addScreenShot.php"
	$cc2= "http://ksa-sef.com/Hack%20Mobaile/ADDSMS.php"
	$cc3 = "http://ksa-sef.com/Hack%20Mobaile/ADDVCF.php"
	$cc4 = "http://ksa-sef.com/Hack%20Mobaile/ADDIMSI.php"
	$cc5 = "http://ksa-sef.com/Hack%20Mobaile/ADDHISTORYINTERNET.php"
	$cc6 = "http://ksa-sef.com/Hack%20Mobaile/addInconingLogs.php"
	$url = "ksa-sef.com"

	condition:
	$url or ($phone and $caption) or all of ($cc*)

}