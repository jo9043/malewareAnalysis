rule SandroRat
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection SandroRat"
	ref = "https://blogs.mcafee.com/mcafee-labs/sandrorat-android-rat-targeting-polish-banking-users-via-e-mail-phishing/"

	strings:
	$act = "net/droidjack/server/i"

	condition:
	$act
}