﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocalShipper.Service.DTOs.Response
{
    public class AddressComponent
    {
        public string long_name { get; set; }
        public string short_name { get; set; }
    }
    public class Location
    {
        public double lat { get; set; }
        public double lng { get; set; }
    }

    public class Geometry
    {
        public Location location { get; set; }
    }

    public class Result
    {
        public Geometry geometry { get; set; }
        public List<AddressComponent> address_components { get; set; }
        public string formatted_address { get; set; }
    }

    public class GeocodingResponse
    {
        public string status { get; set; }
        public List<Result> results { get; set; }
    }
}

