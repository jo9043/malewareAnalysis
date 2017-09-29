rule Ransomware : svpeng android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Ransomware"

	strings:
	$a =  {6e 64 20 79 6f 75 72 27 73 20 64 65 76 69 63 65 20 77 69 6c 6c 20 72 65 62 6f 6f 74 20 61 6e 64}
	$b = "ADD_DEVICE_ADMI"

	condition:
	$a and $b
}

rule Ransomware2 : banker android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Ransomware2"

	strings:
	$str_a = "!2,.B99^GGD&R-"
	$str_b = "22922222222222222222Q^SAAWA"
	$str_c = "t2222222222229222Q^SAAWA"

	condition:
	any of ($str_*)
}

rule Koler_domains : android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Old Koler.A domains"

	strings:
	$dns0 = "police-scan-mobile.com"
	$dns1 = "police-secure-mobile.com"
	$dns2 = "mobile-policeblock.com"
	$dns3 = "police-strong-mobile.com"
	$dns4 = "video-porno-gratuit.eu"
	$dns5 = "video-sartex.us"
	$dns6 = "policemobile.biz"

	condition:
	any of them
}