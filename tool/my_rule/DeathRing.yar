rule DeathRing
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Chinese Trojan DeathRing"
	ref = "https://blog.lookout.com/blog/2014/12/04/deathring/"

	strings:
	$ser = "MainOsService"
	$rec = "ApkUninstallReceiver"

	condition:
	$ser and $rec
}