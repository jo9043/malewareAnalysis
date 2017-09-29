import "hash"

rule Switcher
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Android wifi Switcher variants"
	ref = "https://securelist.com/blog/mobile/76969/switcher-android-joins-the-attack-the-router-club/"

	strings:
	$a0 = "javascript:scrollTo"
	$a1 = "javascript:document.getElementById('dns1')"
	$a2 = "admin:"
	$dns0 = "101.200.147.153"
	$dns1 = "112.33.13.11"
	$dns2 = "120.76.249.59"
	$perm0 = "android.permission.INTERNET"
	$perm1 = "android.permission.ACCESS_WIFI_STATE"

	condition:
	hash.md5(0, filesize) == "2421686AE7D976D19AB72DA1BDE273C537D2D4F9" or
	$perm0 and $perm1 and ($dns0 or $dns1 or $dns2) and all of ($a*)

}