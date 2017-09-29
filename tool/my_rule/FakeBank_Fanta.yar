rule FakeBank_Fanta
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of FakeBank_Fanta"
	ref = "https://blog.trendmicro.com/trendlabs-security-intelligence/fake-bank-app-phishes-credentials-locks-users-out/"

	strings:
	$ser = "SocketService"
	$rec0 = "MyAdmin"
	$rec1 = "Receiver"
	$rec2 = "NetwrokChangeReceiver"

	condition:
	all of them

}