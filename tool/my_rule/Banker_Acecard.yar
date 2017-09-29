rule Banker_Acecard
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Trojan-Banker Acecard"

	strings:
	$a0 = "Cardholder name"
	$a1 = "instagram.php"
	$pkg0 = "starter.fl"
	$pkg1 = "cosmetiq.fl"
	$ser = "starter.CosmetiqFlServicesCallHeadlessSmsSendService"

	condition:
	($pkg0 and $ser) or $pkg1 or all of ($a*)

}