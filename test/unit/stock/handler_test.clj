(ns stock.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [stock.handler :refer :all]))

(facts "Display 'Hello World'"
       (let [response (app (mock/request :get "/"))]
         (fact "Response body is 'Hello World'"
               (:body response) => "{\"message\":\"Hello World\"}")))

(facts "Invalid route does not exists"
       (let [response (app (mock/request :get "/invalid"))]
         (fact "Response body is 'Not Found'"
               (:body response) => "Not Found")))
