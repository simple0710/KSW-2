const partModule = {
  value: "korea",
  func: function () {
    console.log("value = ", this.value);
  },
};

module.exports.moduleName = "partModule";
module.exports.partModule = partModule;
