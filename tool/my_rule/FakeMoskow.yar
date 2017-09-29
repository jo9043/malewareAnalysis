rule Moscow_fake : banker android
{
	meta:
	author ="https://www.github.com/jo9043"
	reference = "https://koodous.com/ https://twitter.com/fdrg21"
	description = "Moskow Droid Development"

	strings:
	$string_a = "%ioperator%"
	$string_b = "%imodel%"
	$string_c = "%ideviceid%"
	$string_d = "%ipackname%"
	$string_e = "VILLLLLL"

	condition:
	all of ($string_*)
}
