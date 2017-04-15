<?php
require "connection.php";
$Dicipline =$_POST["Dicipline"];
$Batch =$_POST["Batch"];
$University =$_POST["University"];

$sql="SELECT notice.Title,notice.Description,notice.NoticeType,user.FirstName,notice.UserId,notice.Date,user.UserId,user.Dicipline,user.Batch,user.University FROM notice,user
where notice.UserId like user.UserId and user.Dicipline like '$Dicipline' and user.Batch like '$Batch' and user.University like '$University' order by notice.Date DESC";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_array($result,MYSQL_NUM))
	{
	$Title = $row[0];
	$Description=$row[1];
	$Type = $row[2];
	$FirstName=$row[3];
	array_push($response,array("Title"=>$Title,"Description"=>$Description,"NoticeType"=>$Type,"FirstName"=>$FirstName));
	}
        echo json_encode($response);
}
mysqli_close($conn);

?>
