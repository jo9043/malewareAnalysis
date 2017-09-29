rule Xbot007
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Xbot007"

	strings:
	$a0 = "xbot007"

	condition:
	any of them
}