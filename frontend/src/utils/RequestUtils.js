const formatGivenParamsAsQueryString = (givenParams) => {
  return Object.keys(givenParams)
        .map(key => encodeURIComponent(key) + '=' + encodeURIComponent(givenParams[key]))
        .join('&');
};

const RequestUtils = {
  formatGivenParamsAsQueryString,
};

export default RequestUtils;
