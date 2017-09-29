rule Autorun
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of attempt to spread through autorun"

	strings:
	$a0 = "[autorun]"
	$a1 = "open="

	condition:
	all of them
}