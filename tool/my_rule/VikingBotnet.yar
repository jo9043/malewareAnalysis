rule VikingBotnet
{
	meta:
	author = "https://www.github.com/jo9043"
	description = "Detection Viking Order Botnet"

	strings:
	$a0 = "cv7obBkPVC2pvJmWSfHzXh"
	$a1 = "http://joyappstech.biz:11111/knock/"
	$a2 = "I HATE TESTERS onGlobalLayout"
	$a3	= "http://144.76.70.213:7777/ecspectapatronum/"

	condition:
	($a0 and $a2) or ($a1 and $a3)
}