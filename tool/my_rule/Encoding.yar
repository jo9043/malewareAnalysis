rule Encoding
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Encryption/Compression"

	strings:
	$a0 = "deflate" fullword
	$a1 = "Jean-loup Gailly"
	$a2 = "inflate" fullword
	$a3 = "Mark Adler"

	$b0 = "OpenSSL" fullword
	$b1 = "SSLeay" fullword

	condition:
	(all of ($a*)) or (all of ($b*))
}