rule Android_Malware : iBanking android
{
	meta:
	author = "Xylitol xylitol@malwareint.com"
	date = "2014-02-14"
	description = "Match first two bytes, files and string present in iBanking"
	reference = "http://www.kernelmode.info/forum/viewtopic.php?f=16&t=3166"

	strings:
	$pk = {50 4B}
	$file1 = "AndroidManifest.xml"
	$file2 = "res/drawable-xxhdpi/ok_btn.jpg"
	$string1 = "bot_id"
	$string2 = "type_password2"

	condition:
	($pk at 0 and 2 of ($file*) and ($string1 or $string2))
}

rule Installer: banker android
{
	meta:
	author = "https://twitter.com/plutec_net"
	reference = "https://koodous.com/"
	description = "Applications with Installer as an application name"

	strings:
	$pkg = "Jk7H.PwcD"

	condition:
	$pkg
}
