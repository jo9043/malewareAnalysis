rule backdoor : dropper
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of fake samples with a backdoor/dropper"
	ref = "https://koodous.com/rulesets/1765"

	strings:
	$url0 = "http://sys.wksnkys7.com"
	$url1 = "http://sys.hdyfhpoi.com"
	$url2 = "http://sys.syllyq1n.com"
	$url3 = "http://sys.aedxdrcb.com"
	$url4 = "http://sys.aedxdrcb.com"

	condition:
	any of them
}