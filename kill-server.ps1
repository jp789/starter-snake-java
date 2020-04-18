# this is a highly sketch script to kill the battlesnake server

<#  
The netstat -ano ... command returns output like this
The goal is to parse  the line with 0.0.0.0:8080, and get the pid from that line, then kill it

TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       8940
... 
#>

$output = (netstat -ano | Select-String "0.0.0.0:8080")
if($output -ne $null){
  $output = (netstat -ano | Select-String "0.0.0.0:8080").ToString()

  # gets the substring of the line from LISTENING onwards, parses it into a 2 element array
  # where second element is the pid
  # some big brain stuff here...
  $index  = $output.IndexOf("LISTENING")
  $tokens = $output.substring($index) -split "       "

  if($tokens.length -gt 2){
    Write-Output "Highly suspicious, kill server manually"
  }
  else{
    Write-Output "Gonna kill battlesnake server now"
    sleep(3)
    taskkill /PID $tokens[1] /F
    sleep(2)
    Write-Output "Should be done-zo now"

  }
}

else{
  Write-Output "no server found, nothing to kill"
}

