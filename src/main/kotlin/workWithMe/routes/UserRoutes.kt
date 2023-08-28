package workWithMe.routes


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import workWithMe.dao.dao
import workWithMe.dto.cses.CaseDto
import workWithMe.dto.cses.caseChild.user.CustomerDto


//call.application.environment.log.info("Hello from /api/v1!")


fun Route.apiRouting() {
    route("/api_path/case") {

        get("/find_all_case") {

            if (dao.findAllCaseDto().isNotEmpty()) {
                val allCaseDto = dao.findAllCaseDto()
                call.respond(allCaseDto)
            } else {
                call.respondText("Case list are empty", status = HttpStatusCode.NotFound)
            }
        }

        get("/find_case/{caseId?}") {

            val caseId = call.parameters["caseId"]?.toString() ?: return@get call.respondText(
                "Missing caseId",
                status = HttpStatusCode.BadRequest
            )
            val case = dao.findCaseByCaseId(caseId)
            val caseDto = case?.let { it1 -> dao.changeCaseToCaseDto(it1) }
            if (caseDto?.caseId == null) {
                return@get call.respondText(
                    "No case with caseId $caseId",
                    status = HttpStatusCode.NotFound
                )
            } else {
                call.respond(caseDto)
            }
        }

        post("/new_case") {

            val caseDto = call.receive<CaseDto>()
            dao.addNewCase(caseDto)
            call.respondText("Case stored correctly", status = HttpStatusCode.Created)

        }

        post("/edit_case") {

            val caseDto = call.receive<CaseDto>()
            dao.editCase(caseDto)
            call.respondText("Case edited correctly", status = HttpStatusCode.OK)
        }

        post("/delete_case") {

            val caseDto = call.receive<CaseDto>()
            dao.deleteCase(caseDto)
            call.respondText("Case deleted correctly", status = HttpStatusCode.Accepted)
        }

    }

    route("/api_path/customer") {

        get("/find_all_customer") {

            if (dao.findAllCustomerDto().isNotEmpty()) {
                val allCustomerDto = dao.findAllCustomerDto()
                call.respond(allCustomerDto)
            } else {
                call.respondText("Customer list are empty", status = HttpStatusCode.NotFound)
            }
        }

        get("/find_customer/{nationalId?}") {

            val nationalId = call.parameters["nationalId"]?.toString() ?: return@get call.respondText(
                "Missing nationalId",
                status = HttpStatusCode.BadRequest
            )
            val customer = dao.findCustomerByNationalId(nationalId)
            val customerDto = customer?.let { it1 -> dao.changeCustomerToCustomerDto(it1) }
            if (customerDto?.nationalId == null) {
                return@get call.respondText(
                    "No customer with nationalId $nationalId",
                    status = HttpStatusCode.NotFound
                )
            } else {
                call.respond(customerDto)
            }
        }

        post("/new_customer") {

            val customerDto = call.receive<CustomerDto>()
            dao.addNewCustomer(customerDto)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)

        }

        post("/edit_customer") {

            val customerDto = call.receive<CustomerDto>()
            dao.editCustomer(customerDto)
            call.respondText("Customer edited correctly", status = HttpStatusCode.OK)
        }

        post("/delete_customer") {

            val customerDto = call.receive<CustomerDto>()
            dao.deleteCustomer(customerDto)
            call.respondText("CustomerDto deleted correctly", status = HttpStatusCode.Accepted)
        }

    }





}
