import "hash"

rule FakeMario
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Fake Android Super Mario"

	strings:
	$str_1 = "lastGame"
	$str_2 = "file:///android_asset/"
	$str_3 = "enableCheats"
	$pkg = "com.ms.cjml"
	$perm0 = "android.permission.INTERNET"
	$perm1 = "android.permission.RECEIVE_BOOT_COMPLETED"

	condition:
	hash.md5(0, filesize) == "9AD4E60648B116006E76542BD701F14D8E2C385F" or
	$pkg or ($perm0 and $perm1 and all of ($str_*))

}