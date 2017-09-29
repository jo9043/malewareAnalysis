rule Trojan_Droidjack
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Driodjack trojan"

	strings:
	$pkg = "net.droidjack.server"
	$act = "net.droidjack.server/i"

	condition:
	$pkg or $act

}