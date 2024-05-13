<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Link Status</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .reachable {
            color: green;
        }
        .not-reachable {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Link Status</h1>
    <table>
        <thead>
            <tr>
                <th>Link</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="entry : ${linkStatuses}">
                <td th:text="${entry.key}"></td>
                <td th:class="${entry.value} ? 'reachable' : 'not-reachable'" th:text="${entry.value} ? 'Reachable' : 'Not Reachable'"></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
