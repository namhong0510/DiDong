<?php
require_once ('connection.php');

if (!isset($_POST['id']) || !isset($_POST['name']) || !isset($_POST['email']) || !isset($_POST['phone'])) {
    die(json_encode(array('status' => false, 'message' => 'Parameters not valid')));
}

$id = $_POST['id'];
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];

$sql = 'UPDATE student set name = ?, email = ?, phone = ? where id = ?';

try{
    $stmt = $dbCon->prepare($sql);
    $stmt->execute(array($name,$email,$phone,$id));

    $count = $stmt->rowCount();

    if ($count == 1) {
        echo json_encode(array('status' => true, 'message' => 'Cập nhật sinh viên thành công'));
    }else {
        die(json_encode(array('status' => false, 'message' => 'Không có sinh viên nào được cập nhật')));
    }


}
catch(PDOException $ex){
    die(json_encode(array('status' => false, 'message' => $ex->getMessage())));
}

?>
