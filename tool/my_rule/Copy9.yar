rule Copy9
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of commercial spyware from Copy9"
	ref = "http://copy9.com"

	strings:
	$a0 = "com.ispyoo"

	condition:
	$a0
}