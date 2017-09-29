
rule leadbolt : advertising android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Leadbolt"
	reference = "https://koodous.com/"

	strings:
	$url = "http://ad.leadbot.net"

	condition:
	$url
}
