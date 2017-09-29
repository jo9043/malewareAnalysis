import "hash"

rule Tordow
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection Trojan-Banker.ANdroidOS.Tordow."
	ref = "https://securelist.com/blog/mobile/76101/the-banker-that-can-steal-anything/"

	strings:
	$pkg = "com.di2.two"
	$act0 = "API2Service/i"
	$act1 = "CryptoUtil/i"
	$act2 = "Loader/i"
	$act3 = "Logger/i"
	$perm = "android.permission.INTERNET"

	condition:
	hash.md5(0, filesize) == "78F162D2CC7366754649A806CF17080682FE538C" or
	hash.md5(0, filesize) == "BBA26351CE41ACBE5FA84C9CF331D768CEDD768F" or
	hash.md5(0, filesize) == "0B7C3BC97B6D7C228F456304F5E1B75797B7265E" or
	$pkg or $act0 and $act1 and $act2 and $act3 and $perm
}