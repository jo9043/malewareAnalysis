rule spam
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of spam-related activity"

	strings:
	$a0 = "e-cards@hallmark.com" nocase
	$a1 = "hallmark e-card" nocase
	$a2 = "rcpt to:" nocase
	$a3 = "mail from:" nocase
	$a4 = "smtp server" nocase
	$a5 = "cialis" nocase fullword
	$a6 = "pharma" nocase fullword
	$a7 = "casino" nocase fullword
	$a8 = "ehlo" nocase fullword
	$a9 = "from: " nocase fullword
	$a10 = "subject: " nocase fullword
	$a11 = "Content-Disposition: attachment;" nocase

	condition:
	3 of them
}