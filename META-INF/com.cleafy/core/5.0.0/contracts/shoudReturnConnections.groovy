package contracts.rules

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return trigger"

    request {
        url("/v2/trigger") {
            queryParameters {
                parameter name: $(consumer(regex('[a-zA-z0-9]+')), producer('event'))
            }
        }
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                [
                        "trigger": "update"
                ],
                [
                        "trigger": "delete"
                ]
        ])
    }
}
