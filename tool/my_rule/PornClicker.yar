rule trojan: pornClickier
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection pornclicker trojan"

	strings:
	$a = "SELEN3333"
	$b = "SELEN33"
	$c = "SELEN333"
	$api = "http://mayis24.4tubetv.xyz/dmr/ya"
	$url = "mayis24.4tubetv.xyz"

	condition:
	($a and $b and $c and $api) or $url
}