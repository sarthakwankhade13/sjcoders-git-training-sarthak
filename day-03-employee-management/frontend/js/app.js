const API_URL = "http://localhost:8080/api/employees";

const employeeForm = document.getElementById("employeeForm");
const employeeTableBody = document.getElementById("employeeTableBody");
const searchInput = document.getElementById("searchInput");
const searchButton = document.getElementById("searchButton");
const message = document.getElementById("message");


// Show message
function showMessage(text, type) {

    message.textContent = text;
    message.className = `alert alert-${type}`;

    setTimeout(() => {
        message.classList.add("d-none");
    }, 3000);
}


// Load all employees
async function loadEmployees() {

    try {

        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to load employees");
        }

        const employees = await response.json();

        renderEmployees(employees);

    } catch (error) {

        console.error(error);

        showMessage("Unable to load employees.", "danger");
    }
}


// Display employees in table
function renderEmployees(employees) {

    employeeTableBody.innerHTML = "";

    if (employees.length === 0) {

        employeeTableBody.innerHTML = `
            <tr>
                <td colspan="8" class="text-center">
                    No employees found
                </td>
            </tr>
        `;

        return;
    }

    employees.forEach(employee => {

        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${employee.id}</td>
            <td>${employee.employeeCode}</td>
            <td>${employee.fullName}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.department}</td>
            <td>${employee.role}</td>
            <td>
                <span class="badge ${
                    employee.status === "ACTIVE"
                        ? "bg-success"
                        : "bg-secondary"
                }">
                    ${employee.status}
                </span>
            </td>
        `;

        employeeTableBody.appendChild(row);
    });
}


// Save employee
employeeForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const employee = {

        fullName:
            document.getElementById("fullName").value.trim(),

        email:
            document.getElementById("email").value.trim(),

        phone:
            document.getElementById("phone").value.trim(),

        department:
            document.getElementById("department").value.trim(),

        role:
            document.getElementById("role").value.trim(),

        status:
            document.getElementById("status").value
    };


    try {

        const response = await fetch(API_URL, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(employee)
        });


        if (!response.ok) {

            let errorMessage = "Failed to save employee";

            try {
                const errorData = await response.json();
                // Spring validation errors come as { message: "..." } via our handler
                // or { errors: [...] } from default Spring error format
                if (errorData.message) {
                    errorMessage = errorData.message;
                } else if (errorData.errors && errorData.errors.length > 0) {
                    errorMessage = errorData.errors.join(", ");
                }
            } catch (_) {
                // response body wasn't JSON — keep default message
            }

            throw new Error(errorMessage);
        }


        await response.json();

        showMessage("Employee saved successfully!", "success");

        employeeForm.reset();

        await loadEmployees();

    } catch (error) {

        console.error(error);

        showMessage(error.message, "danger");
    }

});


// Search employees
searchButton.addEventListener("click", async function () {

    const query = searchInput.value.trim();

    if (!query) {

        await loadEmployees();

        return;
    }


    try {

        const response = await fetch(
            `${API_URL}/search?query=${encodeURIComponent(query)}`
        );

        if (!response.ok) {
            throw new Error("Search failed");
        }

        const employees = await response.json();

        renderEmployees(employees);

    } catch (error) {

        console.error(error);

        showMessage("Unable to search employees.", "danger");
    }

});


// Load employees when page opens
loadEmployees();