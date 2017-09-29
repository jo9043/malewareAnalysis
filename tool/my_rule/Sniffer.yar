rule sniffer
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of Network Sniffer"

	strings:
	$a0 = "sniffer" nocase fullword
	$a1 = "rpcap:////" nocase
	$a2 = "wpcap.dll" nocase fullword
	$a3 = "pcap_findalldevs" nocase
	$a4 = "pcap_open" nocase
	$a5 = "pcap_loop" nocase
	$a6 = "pcap_compile" nocase
	$a7 = "pcap_close" nocase

	condition:
	any of them
}