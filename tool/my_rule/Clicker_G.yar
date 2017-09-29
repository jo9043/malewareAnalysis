rule Clicker_G
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Clicker.G samples"

	strings:
	$a = "upd.php?text="
	$rec = "MyBroadCastReceiver"

	condition:
	all of them
}