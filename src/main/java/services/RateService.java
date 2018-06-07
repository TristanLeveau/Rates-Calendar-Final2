package services;

import daos.RatesDao;
import pojos.Rate;

import java.util.List;

public class RateService {

    private RatesDao rateDao = new RatesDao();

    private static class RateServiceHolder {
        private static RateService instance = new RateService();
    }
    public static RateService getInstance() {
        return RateServiceHolder.instance;
    }

    private RateService() { }

    public void addRate(Rate rate) throws ClassNotFoundException {

        if (rate==null){
            throw new IllegalArgumentException("No rate to add...");
        }
        if (rate.getRate()==0) {
            throw new IllegalArgumentException("Please enter rate value for the new rate");
        }

        if (rate.getStartDate()==null) {
            throw new IllegalArgumentException("Please enter a start date for the new rate");
        }
        if (rate.getCurrency()==null) {
            throw new IllegalArgumentException("Please enter a currency for the new rate");
        }
        if (rate.getSource()==null) {
            throw new IllegalArgumentException("Please enter a source for the new rate");
        }
        if (rate.getDestination()==null) {
            throw new IllegalArgumentException("Please enter a destination for the new rate");
        }
        if (rate.getTransferTime()==0) {
            throw new IllegalArgumentException("Please enter a transfer time for the new rate");
        }
        if (rate.getVehicleType()==null) {
            throw new IllegalArgumentException("Please enter a vehicle for the new rate");
        }
        rateDao.addRate(rate);
    }

    public List<Rate> listAllRates() throws ClassNotFoundException {
        return rateDao.listAllRates();
    }

    public Rate getRateById(Integer idRate) throws ClassNotFoundException { return rateDao.getRateById(idRate); }

    public void updateRate(Rate rate, Integer idRate) throws ClassNotFoundException {
        rateDao.updateRate(rate,idRate);
    }
    }
