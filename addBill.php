<?php
// Database configuration
$host = 'localhost'; // or your database host
$dbname = 'FinanceAnalyzer'; // your database name
$username = 'root'; // your database username
$password = 'newpassword'; // your database password

// Data Source Name (DSN)
$dsn = "mysql:host=$host;dbname=$dbname";

try {
    // Create a PDO instance (connect to the database)
    $pdo = new PDO($dsn, $username, $password);
    // Set the PDO error mode to exception
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Get bill name, amount, and due date from POST request
    $billName = isset($_POST['billName']) ? $_POST['billName'] : '';
    $amount = isset($_POST['amount']) ? $_POST['amount'] : '';
    $dueDate = isset($_POST['dueDate']) ? $_POST['dueDate'] : '';

    // SQL query to insert bill data
    $sql = "INSERT INTO bills (bill_name, amount, due_date) VALUES (:billName, :amount, :dueDate)";

    // Prepare statement
    $stmt = $pdo->prepare($sql);

    // Bind parameters
    $stmt->bindParam(':billName', $billName, PDO::PARAM_STR);
    $stmt->bindParam(':amount', $amount);
    $stmt->bindParam(':dueDate', $dueDate);

    // Execute the query
    $stmt->execute();

    echo "Bill added successfully";
} catch (PDOException $e) {
    // Handle database connection error or query execution error
    echo "Error: " . $e->getMessage();
}
?>
