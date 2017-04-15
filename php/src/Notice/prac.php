<?php
require "connection.php";

$Dicipline ="cse";
$Batch ="16";
$University ="ku";
$UserId="2";

$sql="SELECT notice.NoticeId,notice.Title,notice.Description,user.Batch,user.FirstName,notice.Date,notice.UserId,user.UserId,user.Dicipline,notice.NoticeType,user.University FROM notice,user
where (notice.UserId like user.UserId and user.Dicipline like '$Dicipline' and (user.Batch like '$Batch' or notice.NoticeType like 'For all')and user.University like '$University')
and notice.NoticeId NOT IN(SELECT NoticeId from subscription where UserId like '$UserId')order by notice.Date DESC";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_array($result,MYSQLI_ASSOC))
	{
	$NoticeId=$row["NoticeId"];
	$Title = $row["Title"];
	$Description=$row["Description"];
	$Batch = $row["Batch"];
	$FirstName=$row["FirstName"];
	$Date=$row["Date"];
	array_push($response,array("Title"=>$Title,"Description"=>$Description,"Batch"=>$Batch,"FirstName"=>$FirstName,"NoticeId"=>$NoticeId,"Date"=>$Date));
	}
        echo json_encode($response);
}
mysqli_close($conn);

?>