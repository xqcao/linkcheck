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
                <th>Name</th>
                <th>hostname</th>
                <th>policyStatus</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="link : ${links}">
                <td th:text="${link.name}"></td>
                <td><a th:href="${link.hostname}" th:text="${link.hostname}"></a></td>
                <td th:class="${link.policyStatus} ? 'reachable' : 'not-reachable'">
                    <span th:if="${link.policyStatus}">Reachable</span>
                    <span th:unless="${link.policyStatus}">Not Reachable</span>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
