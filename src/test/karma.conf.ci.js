var baseConfig = require('./karma.conf.js');

module.exports = function (config) {
  baseConfig(config);
  return config.set({
    browsers: ['PhantomJS'],
    singleRun: true,
    autoWatch: false
  });
};