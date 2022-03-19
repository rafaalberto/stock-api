(ns stock.utils-test
  (:require [midje.sweet :refer :all]
            [stock.utils :refer [json-content]]))

(facts "Convert content to JSON with status 200"
       (let [response (json-content {:message "Hello World"})]
         (fact "Status should be 200"
               (:status response) => 200)
         (fact "Headers should be 'application/json; charset=utf-8'"
               (:headers response) => {"Content-Type" "application/json; charset=utf-8"})
         (fact "Content should be 'Hello World'"
               (:body response) => "{\"message\":\"Hello World\"}")))

(facts "Convert content to JSON with status different to 200"
       (let [response (json-content {:message "Hello Clojure!"} 201)]
         (fact "Status should be 201"
               (:status response) => 201)
         (fact "Headers should be 'application/json; charset=utf-8'"
               (:headers response) => {"Content-Type" "application/json; charset=utf-8"})
         (fact "Content should be 'Hello Clojure!'"
               (:body response) => "{\"message\":\"Hello Clojure!\"}")))


