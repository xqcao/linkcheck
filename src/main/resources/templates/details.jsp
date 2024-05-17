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
        .reachable-dot {
            height: 15px;
            width: 15px;
            background-color: green;
            border-radius: 50%;
            display: inline-block;
        }
        .not-reachable-dot {
            height: 15px;
            width: 15px;
            background-color: red;
            border-radius: 50%;
            display: inline-block;
        }
        .health-details {
            margin-left: 20px;
        }
    </style>
</head>
<body>
<ol>
<li><a href="/">Home</a></li>
</ol>
    <h1>Link Status</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>URL</th>
                <th>Status</th>
                <th>Health Details</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="link : ${details}">
                <td th:text="${link.name}"></td>
                <td>
                    <a th:href="'http://' + ${link.hostname}" th:text="'http://' + ${link.hostname}"></a>
                </td>
                <td>
                    <span th:class="${link.policyStatus} ? 'reachable-dot' : 'not-reachable-dot'"></span>
                </td>
                <td>
                    <div th:if="${link.linkDetails != null}">
                        <div>
                            <div>Status: <span th:text="${link.policyStatus}"></span></div>
                            <div th:each="component : ${link.linkDetails['components']}">
                                <div>Component: <span th:text="${component.key}"></span></div>
                                <div>Status: <span th:text="${component.value['policyStatus']}"></span></div>
                                <div class="health-details" th:each="detail : ${component.value['details']}">
                                    <span th:text="${detail.key}"></span>: <span th:text="${detail.value}"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
