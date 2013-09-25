(defproject com.taoensso/carmine "2.2.0"
  :description "Clojure Redis client & message queue"
  :url "https://github.com/ptaoussanis/carmine"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure         "1.4.0"]
                 [org.clojure/tools.macro     "0.1.5"]
                 [commons-pool/commons-pool   "1.6"]
                 [commons-codec/commons-codec "1.8"]
                 [org.clojure/data.json       "0.2.3"]
                 [expectations                "1.4.55"]
                 [com.taoensso/timbre         "2.6.2"]
                 [com.taoensso/nippy          "2.1.0"]]
  :profiles {:1.4   {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5   {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6   {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}
             :dev   {:dependencies []}
             :test  {:dependencies [[ring/ring-core       "1.2.0"]
                                    [com.taoensso/faraday "0.11.0"]]}
             :bench {:dependencies [] :jvm-opts ["-server"]}}
  :aliases {"test-all"    ["with-profile" "test,1.4:test,1.5:test,1.6"
                           "do" "test," "expectations"]
            "test-auto"   ["with-profile" "test" "autoexpect"]
            "start-dev"   ["with-profile" "dev,test,bench" "repl" ":headless"]
            "start-bench" ["trampoline" "start-dev"]
            "codox"       ["with-profile" "test,1.5" "doc"]}
  :plugins [[lein-expectations "0.0.8"]
            [lein-autoexpect   "1.0"]
            [lein-ancient      "0.4.4"]
            [codox             "0.6.6"]]
  :min-lein-version "2.0.0"
  :global-vars {*warn-on-reflection* true}
  :repositories
  {"sonatype"
   {:url "http://oss.sonatype.org/content/repositories/releases"
    :snapshots false
    :releases {:checksum :fail}}
   "sonatype-snapshots"
   {:url "http://oss.sonatype.org/content/repositories/snapshots"
    :snapshots true
    :releases {:checksum :fail :update :always}}})
